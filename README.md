## Spring Interceptor

> 세션 존재 여부에 따른 Controller 접근 허가 / 거부


* 세션 설정
  * /api/v1/session/set 세션 설정
  * /api/v1/session/get 세션 반환


* 세션 존재할 시
  * /admin/real 접근 가능 O
  * /admin/test 접근 가능 O

* 세션 없을 시
  * admin/real 접근 불가능   
           > /admin/** path로 접근시 Intercepter의 preHandler()에 의해 세션이 존재하지 않으면, 컨트롤러 실행 직전에 차단!   
           > 세션이 있으면 허용
  * /admin/test 접근 가능(excludePathPattern 처리로 인해서 /admin/** 중 /admin/test는 예외처리 )


***
