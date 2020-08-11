#!/usr/bin/env bash

curl -XPOST -H "Content-type: application/json" -d '{"firstname":"Ludovika","lastname":"Dagon","email":"ld3dfagon2@inbox.lv","birthdate":"1965-01-02"}' 'http://localhost:8080/api/v1/teacher'