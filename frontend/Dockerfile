FROM node:22-alpine3.20 AS stage1
WORKDIR /frontend
COPY . .
RUN npm install
RUN npm run build


FROM nginx:alpine
COPY --from=stage1 /frontend/nginx.conf /etc/nginx
COPY --from=stage1 /frontend/dist/frontend/browser /usr/share/nginx/html
EXPOSE 80
CMD ["nginx","-g","daemon off;"]