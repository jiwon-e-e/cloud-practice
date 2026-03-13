# cloud

spring 3기 권지원입니다. cloud 주차 과제 제출합니다!

-----

##  :pouting_cat: 1. 프로젝트 소개

클라우드 아키텍쳐 설게&배포 과제는 member-management 관리 프로젝트입니다. 
AWS 에서 예산설정, 네트워크 구축, DB 분리 등의 과정을 진행했습니다. 

### :hatched_chick: ERD

<img width="693" height="302" alt="Image" src="https://github.com/user-attachments/assets/42910276-cd7d-4c4a-a2ea-a3fe05da70ca" />

### :hatched_chick: 트러블슈팅

https://kjw81024.tistory.com/66  

https://kjw81024.tistory.com/67  

https://kjw81024.tistory.com/68  

https://kjw81024.tistory.com/69  
(도커와 관련된 부분인데 아직 CD 부분을 완료하지 못했습니다)  

https://kjw81024.tistory.com/70  

-----

## :crying_cat_face: 2. 주요 기능
1. member 정보를 저장하고 조회하며 프로필 이미지를 등록하여 Presigned URL 을 통해 접근할 수 있습니다.
2. actuator health 를 통해 서버의 상태를 확인할 수 있습니다.
3. ParameterStore 에 저장된 팀명을 확인할 수 있습니다. 


-----



## :pouting_cat: 3. 과제 첨부 사진  

- LV0  
   설정 완료된 AWS Budgets 화면
<img width="1602" height="665" alt="Image" src="https://github.com/user-attachments/assets/d132ed0b-79a4-4e61-8dbc-0ecf1ffecf3d" />

- LV1  
   EC2의 퍼블릭 IP  
   ` 3.35.131.115 `

- LV2  
   Actuator Info endpoint URL 

   RDS 보안 그룹 스크린샷
<img width="1585" height="227" alt="Image" src="https://github.com/user-attachments/assets/deee6bec-5cef-4584-a0cd-5cab78a3b609" />

- LV3  
  발급받은 Presigned URL 1개
```
 https://kjw81024-member-image-files.s3.ap-northeast-2.amazonaws.com/uploads/226fab7a-8d63-45f2-a18d-cbe6de876702_%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-03-01%20211513.png?X-Amz-Security-Token=IQoJb3JpZ2luX2VjELv%2F%2F%2F%2F%2F%2F%2F%2F%2F%2FwEaDmFwLW5vcnRoZWFzdC0yIkcwRQIhAIa4WK1t%2F%2BMKj5zL%2BOemgheSSigKqLABN40NygmEHzcdAiAFPo9V42x96H2JFXwz%2FuSAq%2BXW%2FELU6b2NoGWoGUiNNirRBQiE%2F%2F%2F%2F%2F%2F%2F%2F%2F%2F8BEAAaDDczNTkxMDk2NzI1MyIMuNFsvW27%2Bphj%2FMblKqUFeaNIVwZobwjEYyvKcfwGOV99nv96Owow853rmEuJ2yNYxsmRswVtYtwA2ZLsJa%2BwegvTZ3UqiwGKeSF%2BIs%2BRlToE7VGz4Y96Z%2BpyG7RVz65rI3%2BlTgb7vtInnmQp2ipc6kR%2BJG%2FWsUX7VGkV0Ml7GCHlsRxQFLVJsW8LwSwIFxKUOA54ejX6eNvVWYnTwtDKwpyUWGsSPn5wY7Q3Y%2FhcdH%2BfXTyZSu4Q2qQZGGPQ5LUF15A1oHpu9%2FWzHsNtRWzrzlpZbN%2F%2Fx9p50yfhRJg0qbVyWpMdRh1u8dj%2BcvISrhyoaDvGxX6x8Jf6i7trUJwQk%2BezasXY2VeYoIN%2Bevk4ZknnvrT6SbQG61bzMhySPkcynO0rGqF3Q1CzFJ%2BgYjvlIlus%2BwqyulRySsih95obYfCpoB5nxxGhOO2VGa2QtEIOvA0U9o%2Bpijuhy1sBwR7Hg1FCl3mfUZo9Y%2FgGVIzQPSqchR8ATVABXDTz%2FW8lKal9wSr4wRrmKVFzmaXhGgRfV4veNlrSw8IA%2B1H8%2B%2BrinnmHd55gIX3%2BjH1gFWGAuESACeyIfcy31CAHBIdg0YIKYGcIXs5GcyseBepPqi7iRRkP1Jwbd0npnBeBj4zn6%2FZufpaOtuAFoKBBoh5rXNNaJsEWW0XW1FonITumDbLnKGXDK8l8%2Fcaj9YxVznh2%2B7hnvNaOwu2JOW20WNj93u8SA93DNjXOwsmrnw9Y%2FzD%2BgTziAc1BCjD8UN79rHj%2BYMCadGvieIGyq2YmFMXz8BT%2BwCh452Bj1oEMiUA3CHtGpZ1vz5OmRWuONWUWUl4HFipvvjRk84KjbixpEQk84xqgK%2BrSh3rEkfgil3gy93f89E6a4r6I4iutr2C04y48yzIGJYtUzpeFceZZjzJu0SLT06niLF4w1P%2FNzQY6sQEKEYvsCWXgDkCmE67NoRb6BpdPj1PIjooIdA%2Fr3FO02%2Btd2YbPUqxxFQXbRTb3o2Bs%2B2jUq3Kc9662zqOIQDvSTmwwRZ%2FZ1n%2BSKIy1ad8fME0s97b51FbxV8StTNos7G96w6EN6oOGHGX3A8eOTRI79GVvy8H2%2FiPTfJ%2BKlcoa4le5NWlReUPqrUYu3Cy1IXDajFeIhjmXqvcWbzV08NSLtcGnLimd1leMJFGPrgaSXlw%3D&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Date=20260313T044709Z&X-Amz-SignedHeaders=host&X-Amz-Credential=ASIA2WV5WG7K7GFRRXPX%2F20260313%2Fap-northeast-2%2Fs3%2Faws4_request&X-Amz-Expires=600&X-Amz-Signature=fccaabccbcacb3d0918c6570f2890413dbee8eb3aa24f447018f8b4532e8ecdc
```

- LV4  
  Github Actions 이미지
<img width="1535" height="534" alt="Image" src="https://github.com/user-attachments/assets/ebcc8ae7-f5ea-45d1-95b1-9dbfcfedec99" />
<img width="1079" height="513" alt="Image" src="https://github.com/user-attachments/assets/879b0b1f-ac71-41ed-ae32-58d765f47189" />
  
  

- LV6  
  CloudFront 이미지 URL  
  ` https://d1200cx4g3w3mh.cloudfront.net/uploads/0ea3d861-58fc-4f01-b433-2486ca745ae5_%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202026-03-01%20211513.png `
<img width="1920" height="1080" alt="Image" src="https://github.com/user-attachments/assets/f6f85286-1ee9-4b24-8db4-3316d5b39012" />

-----


# :sunflower: :ear_of_rice: :ear_of_rice: :cat2: :sunflower: :herb: :sunflower: :sunflower: :hatching_chick: :herb: :ear_of_rice: :ear_of_rice: :ear_of_rice: :herb: :sunflower: :sunflower: :sunflower: :leopard:
