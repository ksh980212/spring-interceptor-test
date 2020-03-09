## Spring Interceptor

> 세션 존재 여부에 따른 Controller 접근 허가 / 거부

***

* /api/v1/session/set 세션 설정
* /api/v1/session/get 세션 반환

***

* Session이 존재할시 => /admin/real 접근 가능 O
* Session이 존재할시 => /admin/test 접근 가능 O

***

* Session이 없을시 => /admin/real 접근 불가능
* Session이 없을시 => /admin/test 접근 가능(excludePathPattern 처리로 인해서)
