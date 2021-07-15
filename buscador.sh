#!/bin/bash
#buscar carpetas

for file in $(ls);
do
 if [[ -d $file ]];
 then
  echo $file es un directorio
 fi
done
