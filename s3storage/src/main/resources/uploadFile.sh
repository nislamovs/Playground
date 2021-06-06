#!/usr/bin/env bash


curl -kvvv -XPOST --header "Content-Type: application/json" "http://localhost:8080/api/v1" -d @uploadFile.json | jq .
