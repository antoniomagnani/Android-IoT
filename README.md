# Android-IoT (v0.2.0)
[![Build Status](https://travis-ci.com/antoniomagnani/Android-IoT.svg?branch=master)](https://travis-ci.com/antoniomagnani/Android-IoT)

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

## Authors ##
Luca Calderoni, Antonio Magnani - Università di Bologna (Italy)

## License ##
The source code is released under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version. Please refer to the included files [COPYING](COPYING) and [COPYING.LESSER](COPYING.LESSER).