#!/usr/bin/env bash

curl 'http://localhost:8080/api/v1/teacher/all' | jq .
