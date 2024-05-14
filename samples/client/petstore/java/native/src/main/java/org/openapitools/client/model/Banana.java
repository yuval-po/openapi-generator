/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.math.BigDecimal;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Banana
 */
@JsonPropertyOrder({
  Banana.JSON_PROPERTY_LENGTH_CM
})
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.6.0-SNAPSHOT")
public class Banana {
  public static final String JSON_PROPERTY_LENGTH_CM = "lengthCm";
  private BigDecimal lengthCm;

  public Banana() { 
  }

  public Banana lengthCm(BigDecimal lengthCm) {
    this.lengthCm = lengthCm;
    return this;
  }

   /**
   * Get lengthCm
   * @return lengthCm
  **/
  @javax.annotation.Nullable
  @JsonProperty(JSON_PROPERTY_LENGTH_CM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public BigDecimal getLengthCm() {
    return lengthCm;
  }


  @JsonProperty(JSON_PROPERTY_LENGTH_CM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLengthCm(BigDecimal lengthCm) {
    this.lengthCm = lengthCm;
  }


  /**
   * Return true if this banana object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Banana banana = (Banana) o;
    return Objects.equals(this.lengthCm, banana.lengthCm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lengthCm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Banana {\n");
    sb.append("    lengthCm: ").append(toIndentedString(lengthCm)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `lengthCm` to the URL query string
    if (getLengthCm() != null) {
      joiner.add(String.format("%slengthCm%s=%s", prefix, suffix, URLEncoder.encode(String.valueOf(getLengthCm()), StandardCharsets.UTF_8).replaceAll("\\+", "%20")));
    }

    return joiner.toString();
  }

    public static class Builder {

    private Banana instance;

    public Builder() {
      this(new Banana());
    }

    protected Builder(Banana instance) {
      this.instance = instance;
    }

    public Banana.Builder lengthCm(BigDecimal lengthCm) {
      this.instance.lengthCm = lengthCm;
      return this;
    }


    /**
    * returns a built Banana instance.
    *
    * The builder is not reusable.
    */
    public Banana build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field.
  */
  public static Banana.Builder builder() {
    return new Banana.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Banana.Builder toBuilder() {
    return new Banana.Builder()
      .lengthCm(getLengthCm());
  }

}

