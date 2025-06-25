# 

## Model
www.msaez.io/#/167689080/storming/8c1b1f38a157f0f3c294f95f9c361470

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd infra
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- AuthorWorksManagement
- ReaderExperience
- AdminServiceOperation


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- AuthorWorksManagement
```
 http :8088/works workId="workId"title="title"content="content"copyrightAgreement="copyrightAgreement"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/workHistories historyId="historyId"eventAt="eventAt"eventBy="eventBy"description="description"
```
- ReaderExperience
```
 http :8088/points pointId="pointId"amount="amount"chargedAt="chargedAt"
 http :8088/comments commentId="commentId"content="content"createdAt="createdAt"
```
- AdminServiceOperation
```
 http :8088/announcements announcementId="announcementId"title="title"content="content"createdAt="createdAt"updatedAt="updatedAt"
 http :8088/bestsellerWithHistories historyId="historyId"timestamp="timestamp"
 http :8088/sanctionWithUsers sanctionId="sanctionId"reason="reason"startDate="startDate"endDate="endDate"
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```
