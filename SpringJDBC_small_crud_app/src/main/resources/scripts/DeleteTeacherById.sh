#!/usr/bin/env bash

curl -XDELETE 'http://localhost:8080/api/v1/teacher/2' | jq .