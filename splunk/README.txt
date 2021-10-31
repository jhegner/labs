# Splunk - Instalação Docker

https://splunk.github.io/docker-splunk/

https://hub.docker.com/r/splunk/splunk

$ docker pull splunk/splunk:latest
$ docker pull splunk/universalforwarder:latest

Start a single containerized instance of Splunk Enterprise with the command below, replacing <password> with a password string that conforms to the Splunk Enterprise password requirements.

$ docker run -p 8000:8000 -e "SPLUNK_PASSWORD=q1w2e3r4t5" \
	 -e "SPLUNK_START_ARGS=--accept-license" \
	 -it splunk/splunk:latest

Windows:
	
docker run -p 8000:8000 -e "SPLUNK_PASSWORD=q1w2e3r4t5" -e "SPLUNK_START_ARGS=--accept-license" -it splunk/splunk:latest
	 
This command does the following:

Starts a Docker container using the splunk/splunk:latest image.
Exposes a port mapping from the host’s 8000 port to the container’s 8000 port
Specifies a custom SPLUNK_PASSWORD.
Accepts the license agreement with SPLUNK_START_ARGS=--accept-license. This agreement must be explicitly accepted on every container, or Splunk Enterprise doesn’t start.
You successfully created a standalone deployment with docker-splunk!

After the container starts up, you can access Splunk Web at http://localhost:8000 with admin:<password>.

# Docs:

https://docs.splunk.com/Documentation/Splunk/8.2.2/SearchTutorial/WelcometotheSearchTutorial?ref=hk

https://docs.splunk.com/Documentation/SplunkCloud/8.2.2109/Search/GetstartedwithSearch

https://docs.splunk.com/Documentation/SCS/current/SearchReference/SearchCommandExamples

https://docs.splunk.com/Documentation/SplunkLight/7.3.6/References/Listofsearchcommands

# Learn

https://www.youtube.com/watch?v=tZQLgU5Wxhs
https://www.youtube.com/watch?v=xtyH_6iMxwA

# Dash

https://www.youtube.com/watch?v=Y-TT6unOiPQ

# Java To Splunk

https://www.youtube.com/watch?v=v0lHZDMfBOE
https://www.youtube.com/watch?v=oLoPpKq3JgU
https://community.splunk.com/t5/Getting-Data-In/Example-for-Splunk-HEC-using-Java-Spring-Boot/m-p/398269
https://dzone.com/articles/java-applications-log-message-analytics-using-splu