#!/usr/bin/env bash

HOSTNAME_OR_IP="localhost"
while true; do echo -n "example:$((RANDOM % 100))|c" | nc -w 1 -u $HOSTNAME_OR_IP 8125; done


#then visit localhost/render?from=-10mins&until=now&target=stats.example