package com.example.rest;

public class HttpMethodUsage {

    /**
     * Significance of HTTP Method Types in RESTful Web Services
     *
     * In REST architecture, HTTP methods are used to perform CRUD operations.
     * These methods are just classifications, and it is up to the application
     * to implement the actual persistence logic.
     */
    public class HttpMethodExamples {

        /**
         * GET - Used to retrieve a resource
         * Example: Fetch all employees or a specific employee
         */
        public void getExample() {
            // This would typically fetch data from a database
            System.out.println("GET called - Fetch data about a resource");
        }

        /**
         * POST - Used to create a new resource
         * Example: Add a new employee to the system
         */
        public void postExample() {
            // This would typically insert new data into the database
            System.out.println("POST called - Create a new resource");
        }

        /**
         * PUT - Used to update an existing resource
         * Example: Update details of an existing employee
         */
        public void putExample() {
            // This would typically update existing data in the database
            System.out.println("PUT called - Update a resource");
        }

        /**
         * DELETE - Used to delete a resource
         * Example: Remove an employee from the system
         */
        public void deleteExample() {
            // This would typically remove data from the database
            System.out.println("DELETE called - Delete a resource");
        }

        public static void main(String[] args) {
            HttpMethodExamples example = new HttpMethodExamples();
            example.getExample();
            example.postExample();
            example.putExample();
            example.deleteExample();
        }
    }
}