[![Maven](https://maven-badges.herokuapp.com/maven-central/cz.jirutka.rsql/rsql-parser/badge.svg)](https://maven.apache.org/)
[![Coverage](.github/badges/jacoco.svg)]
[![Tests](https://badgen.net/badge/icon/Tests?icon=bitcoin-lightning&label)](https://junit.org/junit5/)
[![Eclipse](https://badgen.net/badge/icon/eclipse?icon=eclipse&label)](https://junit.org/junit5/)

# Projet_Devops
Projet de devops en M1 info de l'année 2023

## Fonctionnalités

* Création :

  * Créer un Dataframe de 4 manières différentes
  * Ajouter des lignes dans le Dataframe

* Obtention :

  * Obtenir une colonne
  * Obtenir une ligne
  * Obtenir une cellule
  * Obtenir la taille du Dataframe
  * Obtenir toutes les colonnes
  * Obtenir un sous-ensemble du Dataframe
 
* Modification :

  * Modifier une colonne
  * Modifier une case du Dataframe
  * Modifier le nom d'une colonne
  * Modifier toutes les colonnes

* Affichage :

  * Afficher le Dataframe
  * Afficher un sous-ensemble du Dataframe
  * Afficher les i premières lignes
  * Afficher les i dernières lignes

## Choix d'outils

- Git

Nous avons choisi Github car chaque membre du groupe avait déjà un compte sur le site.

- Maven

Est un outil de compilation de code Java, très efficace et facile de compréhension.

- JUnit

A été choisi pour effectuer les tests unitaires du code du projet.

- Revue de code

En ce qui concerne la revue de code, nous l'avons premièrement effectuée directement à l'aide des tests, la personne concernée communiquant les résultats. 
Cette méthode n'étant pas optimale car elle ne représenterait pas fidèlement une situation dans laquelle nous travaillerions en distanciel, nous voulions réaliser ces tests de manière automatique lorsque nous faisions un push par exemple. Néanmoins, les nouvelles fonctionnalitées et les tests étant sur la même branche, nous avons finalement opté pour des 'fakes merge-requests' de la branche dataframe vers le main afin que celui qui s'occupe des tests puisse faire la revue.

- Evaluation de couverture de code

L'évaluation de couverture de code se fait grâce au plugin Jacoco de Maven qui va faire l'évaluation sur les tests unitaires effectués par JUnit.

## Workflow Git

Nous avons fait une branche main sur laquelle nous mettons en place Maven et nous avons modifié le readme.
Pour les features, nous avons tout fait sur une même branche. Les tests étaient au départ sur une branche à part mais au vu du fait que nous codions essentielement côte à côte, nous avons décidé de mettre les tests dans la même branche que les features.
Nous aurions sûrement du créer d'autres branches, comme une branche par feature, qui est le système que nous adopterons désormais sur les prochains projet. Par exemple, la mise en place de maven aurait du être fait sur une branche à part, ainsi que chaque nouvelle fonctionnalitées du dataframe.

## Docker

Nous n'avons pas implémenté Docker par faute de temps.

## Feedback
Voici notre feedback des différents outils utilisés :

Git est un bon outil de versionning, bien que parfois le fait de faire de mauvaises manipulations peut nous faire perdre du temps, il est très utile et permet de travailler correctement sur un même projet, et cela nous fait notemment gagner plus de temps que l'on en perd. C'est un outil que nous allons bien sûr réutiliser plus tard.

Maven 

JUnit est plutôt facile à utiliser et permet de résoudre pas mal de bugs auxquels on avait pas pensé. Petit bémol sur un grand projet il peut être assez long de réaliser correctement tous les tests, néanmoins, nous pensons qu'il est important de faire des tests pour chaque projet.

![Etourmi shiny](https://media.tenor.com/zfonKmPNbiEAAAAM/breakfast-club-cool.gif)
