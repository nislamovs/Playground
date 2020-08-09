#!/usr/bin/env bash

curl 'http://localhost:8080/api/v1/teacher?pagenum=1&pagesize=2&group=id&sort=asc' | jq .