#!/usr/bin/env bash

#Here will be temporarily stored useful scripts for work

#docker run -d -p 27018:27017 mongo
#
#mongodump --host=localhost --port=27017 --db=booklibrary
#
#mongorestore --host=localhost --port=27018 --db=booklibrary ./booklibrary/


. ./constants.sh
. ./apiKeys.sh

cd .. ;
APIKEY=$BOOK_KEY
CATALOGS_ISBNS=()

OUTPUT_LOG="LOG5.txt"

mkdir -p $BOOK_DATA_OUTPUT_FILENAME_PREFIX
mkdir -p $BOOK_OUTPUT_FILENAME_PREFIX
mkdir -p $BOOK_IMAGE_OUTPUT_FILENAME_PREFIX/photos

gen_pub_year_interval_substring() {
    local PUB_YEAR_INTERVAL=$1
    local PUB_YEAR_START=$(echo "$PUB_YEAR_INTERVAL" | gawk -F"-" {'print $1'})
    local PUB_YEAR_END=$(echo "$PUB_YEAR_INTERVAL" | gawk -F"-" {'print $2'})
    local INTERVAL_SUBSTRING=""

    for (( PUB_YEAR=$PUB_YEAR_START; PUB_YEAR<=$PUB_YEAR_END; PUB_YEAR++ ))
    do
        INTERVAL_SUBSTRING="$INTERVAL_SUBSTRING&publicationyear=$PUB_YEAR"
    done

    echo "${INTERVAL_SUBSTRING}"
}