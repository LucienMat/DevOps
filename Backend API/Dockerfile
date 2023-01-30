FROM openjdk:11

COPY --from=0 /usr/src/Main.class .
CMD [ "java -jar app.jar" ]

# COPY app.jar /home/tp/app.jar
# CMD [ "java -jar app.jar" ]
EXPOSE 8080