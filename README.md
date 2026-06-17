This repository contains the lab and solution code for the JB083x edX course.

---
# Background.
I happen to like Java, and many years ago I also acquired a taste for Java Enterprise Edition (Java EE). Since I was all in about learning resources, I found the course _Fundamentals of Java EE Development_, taught by [Red Hat](https://www.redhat.com/en) through [edX](https://www.edx.org), which unfortunately is no longer offered. The related code is available on this [repository](https://github.com/RedHatTraining/JB083x-lab). A few years ago I decided to migrate this codebase to Jakarta EE (Since Java EE was rebranded). I have enjoyed the process so I thought it would be a good idea to propose it as some sort of exercise so you can amuse yourself while doing it.

## Jakarta EE 11 on WildFly 40.
[WildFly 40](https://www.wildfly.org) adds support for [Jakarta EE 11](https://www.jakarta.ee), I consider WildFly a user friendly Application Server, and its website is not cluttered so it is rather easy to find your way on it.

## Running the code.
- Install The JDK 25, set up JAVA_HOME.
- Install Maven's latest version, set up M2_HOME.
- Download and install WildFly 40, I would suggest setting up an alias for the launch script `standalone.sh` inside the `bin` folder.
- Clone this repository.
- `cd` into any of the projects within the `solutions` folder contained in this repository.
- Start WildFly 40 by means of executing the aforementioned launch script.
- Execute `mvn wildfly:deploy`.
- Visit the application URL to see the code in action.

## Jakarta EE 11 Amusements for your own entertainment.
What I am proposing here is for you to choose any of the projects within the `solutions` folder, run the project and familiarize it yourself with the functionality. Then undeploy the project, go to the `labs` folder (Which is not migrated to Jakarta EE 11), and migrate the lab related to the solution you were seeing. In this way you will have the opportunity to
- Getting to know the new Jakarta namespace.
- Changes in the approach for certain features.
- Encounter certain deployments scenarios that may require a fix.
- Take a look at the Application Server log, maybe there is a null pointer exception not reprted by the website.
- See for yourself why the major refactor on `entity-relationships` took place.

There are _TODO_ scattered in the labs.
Do not be so hard with yourself since you do not have access to the accompanying notes for this training, try to enjoy the whole thing, this is for you to have fun and to be in awe. See if there are opportunities for you to use Java 25 new features. If you are really stuck then you can take a peek at the solution code.

### Stay in tune.
If you are getting started with this technology, you will be tempted ro think the instructions were too dry. I invite you to stay tune in my [YouTube channel](https://www.youtube.com/@calebjosueruiztorres) or on my [website](https://www.calebjosue.com) to see content related to this repository with a beginner mindset as always.
