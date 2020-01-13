FROM node:12.13.0-alpine as node

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install
#copy the rest of the project into the image
COPY . .

RUN npm run build-production

# Stage 2
FROM nginx:1.17.7-alpine

COPY --from=node /usr/src/app/dist/api-mgmt-dev-portal /usr/share/nginx/html

#copy nginx configuration
COPY docker/nginx.conf /etc/nginx/conf.d/default.conf
#copy start script
COPY docker/start-nginx-with-devportal.sh /start-nginx-with-devportal.sh

ENTRYPOINT ["sh", "start-nginx-with-devportal.sh"]
