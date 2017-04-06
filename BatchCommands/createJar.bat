@echo off
cd..
jar -cfm AdventureMaker.jar manifest.mf -C bin .
cd BatchCommands
echo Done! - creating jar