<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="style.css" rel="stylesheet">
    <title>Gestão de Projetos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://momentjs.com/downloads/moment-with-locales.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.16/jquery.mask.js"></script>

    <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js"></script>

    
    
    <header class="p-3 mb-3 border-bottom">
        <div class="container">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="#" class="d-flex align-items-center mb-2 mb-lg-0 text-dark text-decoration-none">
                <span class="bi me-2" width="40" height="32"><i class="fa fa-superpowers"></i></span>
            </a>
    
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="home.html" class="nav-link px-2 link-dark">Home</a></li>
              <li><a href="#" class="nav-link px-2 link-dark">Relatórios</a></li>
              <li><a href="projetos.html" class="nav-link px-2 link-secondary">Projetos</a></li>
              <li><a href="#" class="nav-link px-2 link-dark">Configuração</a></li>
            </ul>
    
          </div>
        </div>
      </header>
      <div class="b-example-divider"></div>

  </head>
  <body>
    <br>
    	<c:set var="beep" value="5"/>
   		<c:if test="${beep == '4'}">
	        <!-- Alerta para avisos na página  -->
	        <div class="alert alert-success" style="display: flex; justify-content: center;" role="alert">
	            Membro incluido com sucesso!!
	        </div>
	        <div class="alert alert-danger" style="display: flex; justify-content: center;" role="alert">
	            Aconteceu algum problema na mudança de status do seu projeto!!
	        </div>
        </c:if>
    
    <!-- <div class="title-principal">LISTAGEM DE PROJETOS</div>  -->
    <br>
    <section class="container">
        <div class="form-control">
            <div class="container rounded mt-5 bg-white p-md-5">
                <div class="h2 font-weight-bold">Projetos</div>
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">Nome</th>
                                <th scope="col">Conclusão Prevista</th>
                                <!-- <th scope="col">Responsável</th> -->
                                <th scope="col">Orçamento</th>
                                <th scope="col">Risco</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach var="listValue" items="${projects}">
	                            <tr class="bg-blue">
	                                <td class="pt-3" style="font-weight: bold;"> ${listValue.name} </td>
	                                <td class="pt-3"><fmt:formatDate pattern="dd/MM/yyyy" value="${listValue.endDate}" /></td>
	                                <!-- <td class="pt-3">Alice Oliveira</td> -->
	                                <td class="pt-3">${listValue.budget}</td>
	                                <td class="pt-3">${listValue.risk}</td>
	                                <td class="pt-3">${listValue.status}</td>
	                                <td class="pt-3"><a href="#switchStatus" data-bs-toggle="modal" data-bs-target="#switchStatus" data-bs-whatever="${listValue.status}"> <span class="fa fa-exchange"></span></a></td>
	                                <td class="pt-3"><a  href="#includeMember" data-bs-toggle="modal" data-bs-target="#includeMember" ><span class="fa fa-user-plus"></span></a></td>
	                                <td class="pt-3"><a href="edicaoProjetos.html"><span class="fa fa-pencil"></span></a></td>
	                                <td class="pt-3"><a data-bs-toggle="modal"  href="#modalDelete"><span class="fa fa-trash-o"></span></a></td>
	                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>  
            
        </div>
    </section>


        <!-- Modal de exclusão -->
        <div class="modal fade" id="modalDelete" tabindex="-1" aria-labelledby="modalDelete" aria-hidden="true">
            <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Excluir Projeto</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                Tem certeza que Deseja excluir o projeto ? 
                </div>
                <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
                <button type="button" class="btn btn-danger">Excluir</button>
                </div>
            </div>
            </div>
        </div>

        <!-- Modal Alteração de Status do Projeto-->

        <div class="modal fade" id="switchStatus" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Alteração Status do Projeto</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="mb-3">
                      <label for="recipient-name" class="col-form-label">Status atual:</label>
                      <input disabled type="text" class="form-control" id="recipient-name">
                    </div>
                    <div class="mb-3">
                      <label for="message-text" class="col-form-label"></label>
                      <select class="form-control" id="message-text">
                        <option selected></option>
                        <option value="analise aprovada">Análise Aprovada</option>
                        <option value="analise realizada">Análise Realizada</option>
                        <option value="cancelado">Cancelado</option>
                        <option value="em analise">Em Análise</option>
                        <option value="em andamento">Em Andamento</option>
                        <option value="encerrado">Encerrado</option>
                        <option value="iniciado">Iniciado</option>
                        <option value="planejado">Planejado</option>
                      </select>
                    </div>
	                <div class="modal-footer">
	                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
	                  <button type="button" class="btn btn-success">Confirmar</button>
	                </div>
                  </form>
                </div>
              </div>
            </div>
          </div>


           <!-- Modal para incluir membro ao Projeto-->

        <div class="modal fade" id="includeMember" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header">
                  <h5 class="modal-title" id="exampleModalLabel">Alteração Status do Projeto</h5>
                  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                  <form>
                    <div class="mb-4">
                      <label for="message-text" class="col-form-label"></label>
                      <select class="form-control" id="message-text">
                        <option selected></option>
                        <option value="0">Celso Junior</option>
                        <option value="1">Marlon Ferreira</option>
                        <option value="2">Kamylla Lopes</option>
                        <option value="3">Anna Lis</option>
                      </select>
                    </div>
                  </form>
                </div>
                <div class="modal-footer">
                  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                  <button type="button" class="btn btn-success">Confirmar</button>
                </div>
              </div>
            </div>
          </div>





    <br>
    <div class="b-example-divider"></div>

    <svg xmlns="http://www.w3.org/2000/svg" style="display: none;">
        <symbol id="bootstrap" viewBox="0 0 118 94">
          <title>Footer</title>
          <path fill-rule="evenodd" clip-rule="evenodd" d="M24.509 0c-6.733 0-11.715 5.893-11.492 12.284.214 6.14-.064 14.092-2.066 20.577C8.943 39.365 5.547 43.485 0 44.014v5.972c5.547.529 8.943 4.649 10.951 11.153 2.002 6.485 2.28 14.437 2.066 20.577C12.794 88.106 17.776 94 24.51 94H93.5c6.733 0 11.714-5.893 11.491-12.284-.214-6.14.064-14.092 2.066-20.577 2.009-6.504 5.396-10.624 10.943-11.153v-5.972c-5.547-.529-8.934-4.649-10.943-11.153-2.002-6.484-2.28-14.437-2.066-20.577C105.214 5.894 100.233 0 93.5 0H24.508zM80 57.863C80 66.663 73.436 72 62.543 72H44a2 2 0 01-2-2V24a2 2 0 012-2h18.437c9.083 0 15.044 4.92 15.044 12.474 0 5.302-4.01 10.049-9.119 10.88v.277C75.317 46.394 80 51.21 80 57.863zM60.521 28.34H49.948v14.934h8.905c6.884 0 10.68-2.772 10.68-7.727 0-4.643-3.264-7.207-9.012-7.207zM49.948 49.2v16.458H60.91c7.167 0 10.964-2.876 10.964-8.281 0-5.406-3.903-8.178-11.425-8.178H49.948z"></path>
        </symbol>
        <symbol id="facebook" viewBox="0 0 16 16">
          <path d="M16 8.049c0-4.446-3.582-8.05-8-8.05C3.58 0-.002 3.603-.002 8.05c0 4.017 2.926 7.347 6.75 7.951v-5.625h-2.03V8.05H6.75V6.275c0-2.017 1.195-3.131 3.022-3.131.876 0 1.791.157 1.791.157v1.98h-1.009c-.993 0-1.303.621-1.303 1.258v1.51h2.218l-.354 2.326H9.25V16c3.824-.604 6.75-3.934 6.75-7.951z"/>
        </symbol>
        <symbol id="instagram" viewBox="0 0 16 16">
            <path d="M8 0C5.829 0 5.556.01 4.703.048 3.85.088 3.269.222 2.76.42a3.917 3.917 0 0 0-1.417.923A3.927 3.927 0 0 0 .42 2.76C.222 3.268.087 3.85.048 4.7.01 5.555 0 5.827 0 8.001c0 2.172.01 2.444.048 3.297.04.852.174 1.433.372 1.942.205.526.478.972.923 1.417.444.445.89.719 1.416.923.51.198 1.09.333 1.942.372C5.555 15.99 5.827 16 8 16s2.444-.01 3.298-.048c.851-.04 1.434-.174 1.943-.372a3.916 3.916 0 0 0 1.416-.923c.445-.445.718-.891.923-1.417.197-.509.332-1.09.372-1.942C15.99 10.445 16 10.173 16 8s-.01-2.445-.048-3.299c-.04-.851-.175-1.433-.372-1.941a3.926 3.926 0 0 0-.923-1.417A3.911 3.911 0 0 0 13.24.42c-.51-.198-1.092-.333-1.943-.372C10.443.01 10.172 0 7.998 0h.003zm-.717 1.442h.718c2.136 0 2.389.007 3.232.046.78.035 1.204.166 1.486.275.373.145.64.319.92.599.28.28.453.546.598.92.11.281.24.705.275 1.485.039.843.047 1.096.047 3.231s-.008 2.389-.047 3.232c-.035.78-.166 1.203-.275 1.485a2.47 2.47 0 0 1-.599.919c-.28.28-.546.453-.92.598-.28.11-.704.24-1.485.276-.843.038-1.096.047-3.232.047s-2.39-.009-3.233-.047c-.78-.036-1.203-.166-1.485-.276a2.478 2.478 0 0 1-.92-.598 2.48 2.48 0 0 1-.6-.92c-.109-.281-.24-.705-.275-1.485-.038-.843-.046-1.096-.046-3.233 0-2.136.008-2.388.046-3.231.036-.78.166-1.204.276-1.486.145-.373.319-.64.599-.92.28-.28.546-.453.92-.598.282-.11.705-.24 1.485-.276.738-.034 1.024-.044 2.515-.045v.002zm4.988 1.328a.96.96 0 1 0 0 1.92.96.96 0 0 0 0-1.92zm-4.27 1.122a4.109 4.109 0 1 0 0 8.217 4.109 4.109 0 0 0 0-8.217zm0 1.441a2.667 2.667 0 1 1 0 5.334 2.667 2.667 0 0 1 0-5.334z"/>
        </symbol>
        <symbol id="twitter" viewBox="0 0 16 16">
          <path d="M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z"/>
        </symbol>
      </svg>

    <div class="container">
        <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
          <div class="col-md-4 d-flex align-items-center">
            <span class="text-muted">&copy; 2023 Marlon Ferreira, Inc</span>
          </div>
      
          <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#twitter"/></svg></a></li>
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#instagram"/></svg></a></li>
            <li class="ms-3"><a class="text-muted" href="#"><svg class="bi" width="24" height="24"><use xlink:href="#facebook"/></svg></a></li>
          </ul>
        </footer>
      </div>
      <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker();
            $('.money').mask('00.000.000.000,00', {reverse: true});
        });
        // Script para ativar a validação dos campos obrigatórios no front-end com o bootstrap
        (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
            })
        })();

        // Recuperar Valor do campo Status e enviar para o Modal
        var switchStatusModal = document.getElementById('switchStatus')
        var includeMemberModal = document.getElementById('includeMember')

        includeMemberModal.addEventListener('show.bs.modal', function (event) {
        // Button that triggered the modal
        var button = event.relatedTarget
        // Extract info from data-bs-* attributes
        var recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        //
        // Update the modal's content.
        var modalTitle = includeMemberModal.querySelector('.modal-title')
        var modalBodyInput = includeMemberModal.querySelector('.modal-body input')

        modalTitle.textContent = 'Inclusão de Membro'
})

        switchStatusModal.addEventListener('show.bs.modal', function (event) {
        // Button that triggered the modal
        var button = event.relatedTarget
        // Extract info from data-bs-* attributes
        var recipient = button.getAttribute('data-bs-whatever')
        // If necessary, you could initiate an AJAX request here
        // and then do the updating in a callback.
        //
        // Update the modal's content.
        var modalTitle = switchStatusModal.querySelector('.modal-title')
        var modalBodyInput = switchStatusModal.querySelector('.modal-body input')

        modalTitle.textContent = 'Alteração de Status do projeto: '
        modalBodyInput.value = recipient
})
    </script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>