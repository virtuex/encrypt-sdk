FROM openjdk:8-oracle
COPY build/libs/encrypt-sdk.jar /
CMD ["tail","-f","/dev/null"]