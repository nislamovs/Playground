#!/usr/bin/env bash


mkdir -p ./build/META-INF ;
cd ./build/META-INF ;

#echo "" > MANIFEST.MF ;
rm MANIFEST.MF ;
echo "Manifest-Version: 1.0" >> MANIFEST.MF ;
echo "Created-By: 1.8.0_252 (Private Build)" >> MANIFEST.MF ;
echo "Main-Class: com.example.inventory.InventoryManager" >> MANIFEST.MF ;

cd - ;
cd build ;

jar -cmf ./META-INF/MANIFEST.MF myProgram.jar ./*