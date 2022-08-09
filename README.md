[![Community Extension](https://img.shields.io/badge/Community%20Extension-An%20open%20source%20community%20maintained%20project-FF4700)](https://github.com/camunda-community-hub/community)
![Compatible with: Camunda Platform 8](https://img.shields.io/badge/Compatible%20with-Camunda%20Platform%208-0072Ce)
[![](https://img.shields.io/badge/Lifecycle-Incubating-blue)](https://github.com/Camunda-Community-Hub/community/blob/main/extension-lifecycle.md#incubating-)

# FEEL Tutorial Backend

This repository contains a Camunda 8 Java Spring Boot application that provides a Google Cloud Function
implementation for an interactive FEEL Tutorial.

TODO: add documentation on how to compile, build, deploy and call google function

# Deploy Google Function

```shell
mvn clean install

gcloud functions deploy function-feel-tutorial-gcp-http \
--entry-point org.springframework.cloud.function.adapter.gcp.GcfJarLauncher \
--runtime java17 \
--trigger-http \
--source target/deploy \
--memory 512MB
```

