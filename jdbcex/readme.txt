WebServlet을 활용하여 MVC 구조를 구현

현재까지 문제점
1. 여러개의 컨트롤러를 작성해야함 - TodoDAO나 TodoService와 달리 HttpServlet을 상속하는 여러개의 컨트롤러를 작성해야 한다
2. 동일한 로직의 반복적인 사용 - 게시물의 조회나 수정은 둘다 GET방식으로 동작하지만, 결과를 보이는 JSP만 다른 형태이므로 반복작업 개선 가능
3. 예외처리 부재
4. 반복적인 메소드 호출 - HttpServletRequest나 HttpServletResponse를 활용해서 DTO를 구성하는 작업이나 parseLong 등이 반복됨