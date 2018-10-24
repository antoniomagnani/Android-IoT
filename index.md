# Android-IoT
An Android Client for the IoT Manager framework.

## Synopsis ##
IoT Manager is a general framework which allows users to deal with heterogeneous sensor networks within the smart city context.
It is composed by a client component (front-end) which delivers useful information gathered by sensors (depending on the user's position and settings) and by a server component (back-end) which collects data from sensor networks and exposes them to the front-end.
The framework natively manages georeferencing from both the user's and the sensors' perspective.

## Usage ##
This repository contains an Android project implementing a client application for the IoT Manager framework.
Once installed, the client app can communicate with the framework's back-end to retrieve data collected by different sensors.

In order to address requests to the back-end correctly, the user needs to be provided with a valid username and the corresponding password.
These credentials are mainteined and granted by the [Smart City Lab](http://smartcity.csr.unibo.it) - Università di Bologna, Campus di Cesena, Italy.

## Author ##
Antonio Magnani is a PhD Student in Computer Science and Engineering at the Università di Bologna (Italy).
