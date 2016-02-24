#!/bin/bash

curl -X POST http://localhost:8080/api/v1/sort 'http://longurl.com/aaabbbcc' -H 'Content-Type:application/json'
