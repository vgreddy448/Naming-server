<!-- Test Player Details 

http://localhost:8001/fantasy/player-details/player_Team/SRH/player_Name/David%20Warner 

http://localhost:8101/fantasy/team-details/team_Name/{team_Name}/team_Captain/{team_Captain}

-->INSERT INTO users VALUES (1,1,'admin', 'admin','admin');

Tomcat App Url
http://localhost:8080/PlayerDetails-0.0.1-SNAPSHOT/fantasy/player-details/player_Team/SRH/player_Name/David%20Warner

h2-console
http://localhost:8080/PlayerDetails-0.0.1-SNAPSHOT/h2-console/login.do?jsessionid=a6ee3bafbae12c59fa6a396c9d405f7d

Embedded Tomcat vs Tomcat App Server

Update following in pom.xml 
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
</dependency>

Update this in the spring boot main class
@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(PlayerDetailsApplication.class);
	}