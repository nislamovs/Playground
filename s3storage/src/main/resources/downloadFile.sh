#!/usr/bin/env bash

curl -XGET http://localhost:8080/api/v1/test_s3.txt | jq .