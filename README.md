# maven-with-cicd-build-and-deploy
🟢 FULL LEARNING LIST FROM THIS PROJECT
1️⃣ Environment Setup / Prerequisites

Operating System: Ubuntu VM for self-hosted agent

Installed Tools:

Java 17 (JDK + JRE)

Maven (for build & dependency management)

Git (code version control)

Configured: Azure DevOps self-hosted agent for pipelines

Learned to verify installations with:

java -version
javac -version
mvn -v
git --version

2️⃣ Maven & Project Setup

Learned about Maven project structure

Created / updated pom.xml for:

Java 17

Spring Boot Web

Logging (SLF4J, Logback)

JSON processing (Jackson)

Unit testing (JUnit / Spring Boot Test)

Build plugins (Compiler, Surefire, Spring Boot Maven Plugin)

Learned Maven commands:

mvn clean
mvn compile
mvn test
mvn package
mvn install


Learned how dependencies are added in pom.xml and automatically resolved by Maven.

3️⃣ Coding the Application

Created Spring Boot Main Class:

DemoApplication.java with @SpringBootApplication

Created Controller for Game:

/guess/{number} endpoint → simple number guessing game

/health endpoint → simple health check

Created UI for Game:

index.html in src/main/resources/static/

JavaScript fetch API calls backend /guess/{n}

Created Controller to redirect / to /index.html (HomeController.java)

Skills Learned:

REST API creation

Static content serving in Spring Boot

Simple frontend-backend integration

Redirection mapping in Spring Boot

4️⃣ Unit Testing

Created GameControllerTest.java

Tested /health endpoint using JUnit

Learned how Maven automatically runs unit tests during pipeline build

5️⃣ Azure DevOps CI Pipeline (Continuous Integration)

Learned how to create YAML pipeline for CI:

Verify Java & Maven versions

Run Maven compile & test

Package the application into a JAR

Publish artifact

Learned artifact management:

Azure DevOps PublishBuildArtifacts@1

Learned SonarQube integration option (optional, not yet implemented)
================================================================

6️⃣ Azure DevOps CD Pipeline (Continuous Deployment)

Learned to deploy a Java Spring Boot JAR to Azure App Service

Used AzureWebApp@1 task in YAML

Connected pipeline to App Service

Learned artifact download and deployment steps

Learned to configure App Service runtime (Java 17, Linux)

===================================================================


7️⃣ Verification / Testing Post-Deployment

Checked live App Service URL

Tested:

/ → game UI loads

/index.html → static page loads

/guess/{number} → backend logic

/health → application health

Learned to debug Whitelabel Error Pages

Correct placement of index.html

Added HomeController to map / → /index.html

Checked Azure App Service logs

Verified Java version & startup command

=======================================================

8️⃣ Key DevOps & CI/CD Concepts Learned

Self-hosted vs Microsoft-hosted agents

Pipelines trigger automatically on push (main branch)

Artifact generation & publishing

Multi-step build process:

Build → Test → Package → Deploy

Pipeline YAML structure:

Stages (Build, Deploy)

Jobs, Tasks, Scripts

Environment management in Azure:

App Service configuration

Java version settings

Startup command

How application updates flow end-to-end automatically



9️⃣ Optional / Advanced Learnings

How to integrate SonarQube (for code quality)

How to add multi-stage deployment (Dev → UAT → Prod)

Application Insights for monitoring

Using Spring Profiles for environments

Extending app (like adding a mini game or feature)
=============

✅ Final Outcome of This Project

Local Maven project with Java 17 & Spring Boot ready to build.

Unit tested and packaged into a JAR automatically via pipeline.

Automatically deployed to Azure App Service.

Live web game accessible via browser:

Game API working

UI loaded

Health check endpoint accessible

Learned full Dev → CI → CD → Verification workflow.

If you want, I can also make a diagram / visual flowchart showing all steps from code → CI → CD → live game — that’s perfect for documentation or interviews.

Do you want me to make that?



==============

Perfect! Let’s make a visual DevOps + CI/CD flowchart for your project. I’ll break it down step by step so you can show it in interviews or documentation.

Here’s a diagram in text / flow style and I’ll also give a ready-to-use Mermaid version for diagrams if you want to generate one.

🎨 Dev → CI → CD → Live Game Flow
+-----------------+
|  Local Machine  |
| (Developer)     |
+-----------------+
          |
          | 1️⃣ Code / Update
          v
+-----------------+
|  Git Repository |
| Azure DevOps    |
+-----------------+
          |
          | 2️⃣ Push to main branch
          v
+-----------------+
|  CI Pipeline    |
| (Build Stage)   |
+-----------------+
| - Verify Java 17|
| - Verify Maven  |
| - Maven Clean   |
| - Compile       |
| - Unit Test     |
| - Package JAR   |
| - Publish Artifact |
+-----------------+
          |
          | 3️⃣ Artifact ready
          v
+-----------------+
|  CD Pipeline    |
| (Deploy Stage)  |
+-----------------+
| - Download Artifact |
| - Deploy to Azure  |
|   App Service      |
+-----------------+
          |
          | 4️⃣ Application Live
          v
+--------------------------+
|  Azure App Service       |
| - index.html (UI)       |
| - /guess API (Backend)  |
| - /health endpoint       |
+--------------------------+
          |
          | 5️⃣ User Access / Testing
          v
+--------------------------+
|  Browser / Client        |
| - Play Guess Game        |
| - Test API endpoints     |
+--------------------------+

🌟 Ready-to-Use Mermaid Diagram

You can paste this into Mermaid Live Editor or VS Code Mermaid Preview:

flowchart TD
    A[Local Machine\nDeveloper] --> B[Git Repository\nAzure DevOps]
    B --> C[CI Pipeline\n(Build Stage)]
    C --> D[CD Pipeline\n(Deploy Stage)]
    D --> E[Azure App Service\n- index.html\n- /guess API\n- /health]
    E --> F[Browser / Client\n- Play Game\n- Test API]

    subgraph "CI Pipeline"
        C1[Verify Java 17]
        C2[Verify Maven]
        C3[Maven Clean & Compile]
        C4[Run Unit Tests]
        C5[Package JAR]
        C6[Publish Artifact]
        C1 --> C2 --> C3 --> C4 --> C5 --> C6
    end

    subgraph "CD Pipeline"
        D1[Download Artifact]
        D2[Deploy to Azure App Service]
        D1 --> D2
    end

✅ Explanation

Dev writes code locally (Spring Boot + Game)

Push code to Azure DevOps Git repository → triggers CI pipeline

CI pipeline:

Verifies environment (Java & Maven)

Runs build & unit tests

Packages artifact (JAR)

Publishes artifact for deployment

CD pipeline:

Downloads artifact

Deploys JAR to Azure App Service (Linux, Java 17)

App Service hosts:

/ → index.html

/guess/{n} API

/health endpoint

User can play game from browser → full end-to-end DevOps cycle complete