# SCM Changelog Reports Plugin

## :checkered_flag: How To Start

1. Install Java 17, go link for install [SDKMAN](https://sdkman.io/install)

   ```shell
   sdk install java x.y.z-vendor
   ```

2. Set it as your default JVM

   ```shell
   export JAVA_HOME='$HOME/.sdkman/candidates/java/current'
   ```

3. Clone this repository:

   ```shell
   git clone https://github.com/untalsanders/changelog-maven-plugin.git
   ```

4. Run application

   ```shell
   # Install package
   ./mvnw clean install
   ```

   ```shell
   # Generate Report
   ./mvnw io.github.untalsanders.plugins:changelog-maven-plugin:changelog
   ```

## :wolf: Author

- [Sanders Gutiérrez](https://untalsanders.github.io) - System Engineer (Java Developer)

## :unlock: License

This project is software licensed under the [BSL 1.0 license](LICENSE).