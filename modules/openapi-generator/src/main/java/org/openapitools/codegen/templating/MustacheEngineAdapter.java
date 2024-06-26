/*
 * Copyright 2019 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.templating;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.openapitools.codegen.utils.loaders.MustacheHelperLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;


public class MustacheEngineAdapter implements TemplatingEngineAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(TemplatingEngineAdapter.class);

    private Map<String, Mustache.Lambda> _helpers = new HashMap<>();

    /**
     * Provides an identifier used to load the adapter. This could be a name, uuid, or any other string.
     *
     * @return A string identifier.
     */
    @Override
    public String getIdentifier() {
        return "mustache";
    }

    private final String[] extensions = {"mustache"};
    Mustache.Compiler compiler = Mustache.compiler();

    /**
     * Compiles a template into a string
     *
     * @param executor    From where we can fetch the templates content (e.g. an instance of DefaultGenerator)
     * @param bundle       The map of values to pass to the template
     * @param templateFile The name of the template (e.g. model.mustache )
     * @return the processed template result
     * @throws IOException an error occurred in the template processing
     */
    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile) throws IOException {
        Template tmpl = compiler
                .withLoader(name -> findTemplate(executor, name))
                .defaultValue("")
                .compile(executor.getFullTemplateContents(templateFile));

        this.insertCustomHelpersToContext(bundle);

        LOGGER.debug("Registered {} custom Mustache helpers", this._helpers.size());
        return tmpl.execute(bundle);
    }

    @SuppressWarnings("java:S108") // catch-all is expected, and is later thrown
    public Reader findTemplate(TemplatingExecutor generator, String name) {
        for (String extension : extensions) {
            final String templateName = name + "." + extension;
            try {
                return new StringReader(generator.getFullTemplateContents(templateName));
            } catch (Exception exception) {
                LOGGER.error("Failed to read full template {}, {}", templateName, exception.getMessage());
            }
        }

        throw new TemplateNotFoundException(name);
    }

    public Mustache.Compiler getCompiler() {
        return compiler;
    }

    public void setCompiler(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public String[] getFileExtensions() {
        return extensions;
    }

    @Override
    public void useCustomHelpersFile(File helpersJar) throws IOException, FileNotFoundException {
        if (helpersJar == null) {
            LOGGER.warn("Helpers file is null. Ignoring");
            return;
        }

        if (!helpersJar.exists()) {
            LOGGER.warn("Helpers file at {} does not exist. Ignoring", helpersJar.getPath());
            return;
        }

        try {
            MustacheHelperLoader loader = new MustacheHelperLoader(helpersJar);
            loader.load();
            this._helpers = loader.getHelpers();
        } catch (Exception e) {
            LOGGER.error("Could not load customer template helpers from {} - {}", helpersJar.getPath(), e.getMessage());
            throw e;
        }
    }

    /**
     * Inserts all available helpers into the given context
     * @param context The Mustache engine context to insert helper Mustache.Lambdas to
     * @throws IllegalStateException Some helper methods have keys that conflict with ones on the current context
     */
    private void insertCustomHelpersToContext(Map<String, Object> context) {
        for (var entry : this._helpers.entrySet()) {
            Object existingValue = context.putIfAbsent(entry.getKey(), entry.getValue());
            if (existingValue != null && !(existingValue instanceof Mustache.Lambda)) {
                throw new IllegalStateException("The Mustache context already has a definition for '" + entry.getKey() + "' that is not a Mustache.Lambda");
            }
            LOGGER.debug("Registered helper '{}' ({})", entry.getKey(), entry.getValue().getClass().getCanonicalName());
        }
    }
}
