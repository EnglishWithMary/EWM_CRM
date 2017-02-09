<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-sm-12">
        <h2 class="page-header">${person.lastName} ${person.firstName} ${person.middleName} </h2>
    </div>
</div>
<div class="row">
    <div class="col-sm-5 col-sm-offset-3">
        <div class="panel panel-default">
            <div class="panel-heading">
                <strong>Testing results</strong>
            </div>
            <div class="panel-body">
                <sf:form method="post" modelAttribute="studentLevelHistory" action="/students/${studentLevelHistory.id}/save-testing-result">
                    <div class="container">
                        <h4>Testing date <input name="testingDate" type="date" value=${checkpointDate}/></h4>
                    </div>
                     <fieldset class="form-group">

                         <div class="container">
                             <h4>Type of test</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.testType=='ENTRY_TEST'}">
                                     <label class="radio-inline"><input type="radio" name="testType" id="1" value="ENTRY_TEST" checked>ENTRY</label>
                                     <label class="radio-inline"><input type="radio" name="testType" id="2" value="GRADUATE_TEST" >GRADUATE</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.testType=='GRADUATE_TEST'}">
                                     <label class="radio-inline"><input type="radio" name="testType" id="1" value="ENTRY_TEST" >ENTRY</label>
                                     <label class="radio-inline"><input type="radio" name="testType" id="2" value="GRADUATE_TEST" checked>GRADUATE</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="testType" id="1" value="ENTRY_TEST" checked>ENTRY</label>
                                     <label class="radio-inline"><input type="radio" name="testType" id="2" value="GRADUATE_TEST" >GRADUATE</label>
                                 </c:otherwise>
                             </c:choose>

                         </div>

                         <div class="container">
                            <h4>Grammar</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.grammar=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.grammar=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                 label class="radio-inline"><input type="radio" name="grammar" id="0" value="Start" checked>Start</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="1" value="A1">A1</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="2" value="A2">A2</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="3" value="B1">B1</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="4" value="B2">B2</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="5" value="C1">C1</label>
                                 <label class="radio-inline"><input type="radio" name="grammar" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                        </div>

                        <div class="container">
                            <h4>Speaking</h4>
                            <c:choose>
                                <c:when test="${studentLevelHistory.speaking=='Start'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start" checked>Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='A1'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1" checked>A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='A2'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2" checked>A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='B1'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1" checked>B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='B2'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2" checked>B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='C1'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1" checked>C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:when>
                                <c:when test="${studentLevelHistory.speaking=='C2'}">
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start">Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2"  checked>C2</label>
                                </c:when>
                                <c:otherwise>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="0" value="Start" checked>Start</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="1" value="A1">A1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="2" value="A2">A2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="3" value="B1">B1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="4" value="B2">B2</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="5" value="C1">C1</label>
                                    <label class="radio-inline"><input type="radio" name="speaking" id="6" value="C2">C2</label>
                                </c:otherwise>
                            </c:choose>
                        </div>
                         <div class="container">
                             <h4>Listening</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.listening=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.listening=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="listening" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="listening" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                          <div class="container">
                             <h4>Reading</h4>
                              <c:choose>
                                  <c:when test="${studentLevelHistory.reading=='Start'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start" checked>Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='A1'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1" checked>A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='A2'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2" checked>A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='B1'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1" checked>B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='B2'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2" checked>B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='C1'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1" checked>C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:when>
                                  <c:when test="${studentLevelHistory.reading=='C2'}">
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start">Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2" checked>C2</label>
                                  </c:when>
                                  <c:otherwise>
                                      <label class="radio-inline"><input type="radio" name="reading" id="0" value="Start" checked>Start</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="1" value="A1">A1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="2" value="A2">A2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="3" value="B1">B1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="4" value="B2">B2</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="5" value="C1">C1</label>
                                      <label class="radio-inline"><input type="radio" name="reading" id="6" value="C2">C2</label>
                                  </c:otherwise>
                              </c:choose>
                         </div>
                         <div class="container">
                             <h4>Vocabulary</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.vocabulary=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.vocabulary=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="vocabulary" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                         <div class="container">
                             <h4>Pronunciation</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.pronunciation=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.pronunciation=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="pronunciation" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                         <div class="container">
                             <h4>Writing</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.writing=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.writing=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="writing" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="writing" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                         <div class="container">
                             <h4>Fluency</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.fluency=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1" checked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.fluency=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="fluency" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>
                         <div class="container">
                             <h4>Spelling</h4>
                             <c:choose>
                                 <c:when test="${studentLevelHistory.spelling=='Start'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='A1'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1" cheked>A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='A2'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2" checked>A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='B1'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1" checked>B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='B2'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2" checked>B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='C1'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1" checked>C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:when>
                                 <c:when test="${studentLevelHistory.spelling=='C2'}">
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start">Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2" checked>C2</label>
                                 </c:when>
                                 <c:otherwise>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="0" value="Start" checked>Start</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="1" value="A1">A1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="2" value="A2">A2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="3" value="B1">B1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="4" value="B2">B2</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="5" value="C1">C1</label>
                                     <label class="radio-inline"><input type="radio" name="spelling" id="6" value="C2">C2</label>
                                 </c:otherwise>
                             </c:choose>
                         </div>

                        <div class="row">
                            <div class="col-sm-4 col-sm-offset-4">
                                <input type="submit" value="Save results" class="btn btn-success"/>
                                <input type="hidden" class="hidden" name="studentId" value="${student.id}"/>
                            </div>
                        </div>
                    </fieldset>
                </sf:form>
            </div>
        </div>
    </div>
</div>