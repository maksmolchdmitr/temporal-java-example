# temporal-java-example

## Example of use

- Start temporal: `temporal server start-dev`
- Start java spring application: `mvn spring-boot:run`
- Start workflow:
  - `temporal workflow start --task-queue SAY_HELLO --type HelloWorkflow -i \"maksmolch\"`
  - `temporal workflow start --task-queue SAY_HELLO --type HelloWorkflow -i \"Hollow\ knight\"`