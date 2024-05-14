// Code generated by OpenAPI Generator (https://openapi-generator.tech); DO NOT EDIT.

/*
 * OpenAPI Petstore
 *
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * API version: 1.0.0
 */

package petstoreserver




// Category - A category for a pet
type Category struct {

	Id int64 `json:"id,omitempty"`

	Name string `json:"name,omitempty"`
}

// AssertCategoryRequired checks if the required fields are not zero-ed
func AssertCategoryRequired(obj Category) error {
	return nil
}

// AssertCategoryConstraints checks if the values respects the defined constraints
func AssertCategoryConstraints(obj Category) error {
	return nil
}
