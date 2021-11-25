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

https://docs.splunk.com/Documentation/Splunk/8.2.2/SearchReference/Top?ref=hk

https://dev.splunk.com/enterprise/docs/developapps/addsupport/logging/loggingbestpractices/
https://community.splunk.com/t5/Getting-Data-In/How-to-log-JSON-to-Splunk-and-optimize-for-spath/m-p/328158
https://community.splunk.com/t5/Splunk-Search/How-to-filter-a-JSON-data-log-when-one-of-the-fields-in-that/m-p/432192

https://community.splunk.com/t5/Splunk-Search/How-to-extract-fields-from-JSON-data-in-Splunk/m-p/274976
https://docs.splunk.com/Documentation/Splunk/6.3.3/SearchReference/spath
https://dev.splunk.com/enterprise/docs/devtools/customsearchcommands/createcustomsearchcmd/
https://www.crestdatasys.com/blogs/how-to-extract-complex-field-from-nested-json-events-using-splunk-spl/

https://docs.splunk.com/Documentation/Splunk/8.2.2/SearchReference/Stats?ref=hk#Basic_examples (Basic examples)
https://docs.splunk.com/Documentation/SplunkCloud/latest/SearchReference/DateandTimeFunctions
https://community.splunk.com/t5/Splunk-Search/How-to-find-events-between-date-ranges/m-p/320981

https://education.splunk.com/catalog

# Learn

https://www.youtube.com/watch?v=tZQLgU5Wxhs
https://www.youtube.com/watch?v=xtyH_6iMxwA
https://www.youtube.com/watch?v=C3k_v0lzmaM
https://www.youtube.com/watch?v=tRfm9RMAkzk&t=2s
https://www.youtube.com/watch?v=bpP2tZPoK8M

# Dash

https://www.youtube.com/watch?v=Y-TT6unOiPQ

# Docker

https://www.youtube.com/watch?v=WFovg0NEWHg

# Java To Splunk

https://www.youtube.com/watch?v=v0lHZDMfBOE
https://www.youtube.com/watch?v=oLoPpKq3JgU
https://community.splunk.com/t5/Getting-Data-In/Example-for-Splunk-HEC-using-Java-Spring-Boot/m-p/398269
https://dzone.com/articles/java-applications-log-message-analytics-using-splu


# Linux 

https://docs.rackspace.com/support/how-to/create-sudo-user-in-centos/
https://devconnected.com/how-to-change-user-on-linux/
https://devconnected.com/how-to-list-users-and-groups-on-linux/

# Others

http://logback.qos.ch/manual/mdc.html
https://stackoverflow.com/questions/28536910/using-different-pattern-for-a-specific-logger-in-logback
https://stackoverflow.com/questions/11121846/how-to-configure-logback-for-package
https://reflectoring.io/tracing-with-spring-cloud-sleuth/
https://sematext.com/blog/logback-tutorial/
https://stackify.com/logging-logback/
https://stackoverflow.com/questions/14168684/creating-a-custom-layout-in-logback
https://github.com/logfellow/logstash-logback-encoder

# Comandos Splunk

* Table command -> Retorna uma tabela que é formada apenas pelos campos especificados como argumentos
index="index_mylabs" | table _time sourcetype source date_hour

* Rename command -> Renomeia o nome do campo informado
index="index_mylabs" | table _time sourcetype source date_hour | rename source as origem date_hour as hora

* Fields command -> Mantem ou remove campos do resultado baseado no criterio de busca
index="index_mylabs" | table _time sourcetype source date_hour | rename source as origem date_hour as hora | fields - origem

* Dedup command -> Remove os eventos que contem combinações de eventos identicas
index="index_mylabs" | table _time source sourcetype | dedup source

* Sorts command -> Ordena todos os resultados com base os campos especificados. O primeiro argumento determina a quantidade de resultados
index="index_mylabs" | table _time source sourcetype | dedup source | sort _time
index="index_mylabs" | table _time source sourcetype | dedup source | sort _time desc
index="index_mylabs" | table _time source sourcetype | dedup source | sort -_time // decrescente
index="index_mylabs" | table _time source sourcetype | dedup source | sort +_time // crescente

* Top command -> Pesquisa os maiores valores comuns dos campos informados. Calcula a quantidade e percentagem da frequencia nos eventos
index="index_mylabs" | top source

* Rare command -> Apresenta o menor valor comum no campo
index="index_mylabs" | rare source

# Consultas nos logs

Pesquisa autor por nome - index="index_mylabs" | spath payload | search payload.autor=magali
Pesquisa por canal
Pesquisa por noticia
Pesquisa por leitor
Pesquisa noticias publicadas por um autor
Pesquisa noticias lidas por um leitor
Pesquisa noticias por data de publicacao
Pesquisa autores por data de publicacao

Pesquisa quantidade de autores - index="index_mylabs" message = "Payload leitor" | spath payload | stats count(payload.nome), distinct_count(payload.nome), values(payload.nome)
Pesquisa quantidade de canais
Pesquisa quantidade de noticias
Pesquisa quantidade de noticias publicadas por um autor
Pesquisa quantidade de noticias publicadas por autores
Pesquisa quantidade de noticias publicadas por canal
Pesquisa quantidade de noticias fakenews
Pesquisa quantidade de fakenews por autor
Pesquisa quantidade de noticias lidas por leitor
Pesquisa quantidade de noticias por data de publicacao