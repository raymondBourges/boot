# Référence
[doc spring-boot](http://docs.spring.io/spring-boot/docs/1.0.2.RELEASE/reference/htmlsingle/)

# ÉTAPES
* Exemple bateau ["/"](http://localhost:9090/)
* Ajout de spring data (utilisation de [lombock](http://projectlombok.org/) et [queryDsl](http://www.querydsl.com/))
    * Avec une base en mémoire  
* Ajout d'accès REST pour le CRUD ["/persons"](http://localhost:9090/persons/)
* Une requête avec du queryDSL ["/query?name=a](http://localhost:9090/query?name=a)
* Ajout de spring security (CAS)
* Ajout d'une vue Angular JS ["/app"](http://localhost:9090/app/)

# TODO
* Spring data
    * Avec une base MySQL

# USAGE
* Configuration par défaut
    * **mvn spring-boot:run**        
* Configuration avancée par surcharge des valeurs de ["application.properties"](src/main/resources/application.properties)
    * Ex : **mvn spring-boot:run -Drun.arguments="--cas.url.prefix=http://cas.domain.fr/cas"**