#!/usr/bin/env bash

curl 'http://localhost:8080/api/v1/pupil/findbyemail?email=cwillimott7@yahoo.com' | jq .