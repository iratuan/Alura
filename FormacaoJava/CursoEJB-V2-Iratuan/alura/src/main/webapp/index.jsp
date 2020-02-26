<!doctype html>
<html lang="pt-br">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">

<title>Alura Agendador de Email</title>

</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-dark">
			<a class="navbar-brand text-white" href="#">Alura Agendador de
				Email</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
		</nav>
	</header>
	<div id="app" class="container mt-5">
		<form @submit="agendar" method="post">
			<div class="alert alert-danger" role="alert" v-if="form.erro">
				<p v-for="mensagemErro in form.mensagemErros">{{mensagemErro}}</p>
			</div>
			<div class="form-group">
				<label for="email">Email</label> <input type="email"
					class="form-control" id="email" v-model="form.email" name="email"
					aria-describedby="emailHelp" placeholder="Informe o email">
				<small id="emailHelp" class="form-text text-muted">Email do
					destinat�rio. O email remetente � o email do sistema</small>
			</div>
			<div class="form-group">
				<label for="assunto">Assunto</label> <input type="text"
					class="form-control" id="assunto" v-model="form.assunto"
					name="assunto" placeholder="Assunto">
			</div>
			<div class="form-group">
				<label for="mensagem">Mensagem</label>
				<textarea class="form-control" id="mensagem" name="mensagem"
					v-model="form.mensagem" rows="5"></textarea>
			</div>

			<button type="button" v-on:click="agendar" class="btn btn-primary">Agendar</button>
		</form>
		<table id="emails" class="table mt-5" v-if="!erro">
			<thead>
				<tr>
					<th scope="col">N�mero do Agendamento</th>
					<th scope="col">Email</th>
					<th scope="col">Assunto</th>
					<th scope="col">Status</th>
				</tr>
			</thead>
			<tbody>
				<tr v-for="agendamento in agendamentos">
					<th scope="row">{{agendamento.id}}</th>
					<td>{{agendamento.email}}</td>
					<td>{{agendamento.assunto}}</td>
					<td>{{agendamento.status}}</td>

				</tr>

			</tbody>
		</table>
		<div id="tableError" class="table mt-5" v-if="erro">
			{{mensagem}}</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"
		integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"
		integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k"
		crossorigin="anonymous"></script>
	<script src="https://unpkg.com/axios/dist/axios.min.js"></script>

	<script>

            Vue.prototype.$url = 'http://localhost:8080/alura/resources/';

            var app = new Vue({
                el: '#app',
                data: {
                    agendamentos: [],
                    mensagem : null,
                    erro: false,
                    form:{
                        email:'',
                        assunto:'',
                        mensagem:'',
                        erro: false,
                        mensagemErros:''
                    }

                },
                methods: {
                    agendar: function (e) {
                        var config = {
                            headers: {'Content-Type': 'application/json'}
                        };

                        var data = '{"email": "' + this.form.email +'"'
                               +  ', "assunto": "' + this.form.assunto+'"'
                               + ', "mensagem": "' + this.form.mensagem +'"'
                               +'}';



                        axios
                            .post(this.$url + 'agendamentoemail',data, config )
                            .then(response => {
                                carregarAgendamentos(this);
                                this.limparForm();
                            })
                            .catch(error => {

                                this.form.erro = true;
                                if (error.response) {
                                    this.form.mensagemErros = error.response.data.mensagens;
                                }
                                else {
                                    this.form.mensagemErros = ["Servi�o indispon�vel. Tente novamente mais tarde."];
                                }
                            });


                    },
                    limparForm: function (){
                        this.form = {
                            email:'',
                            assunto:'',
                            mensagem:'',
                            erro: false,
                            mensagemErros:''
                        }
                    }
                },
                mounted () {
                   carregarAgendamentos(this);
                }

            });


            function carregarAgendamentos(app){
                axios
                    .get(app.$url + 'agendamentoemail')
                    .then(response => {
                        app.agendamentos = response.data;
                        app.agendamentos.forEach(agendamento => formatarStatus(agendamento));
                    })
                    .catch(error => {

                        app.erro = true;
                        if (error.response) {
                            this.mensagem = error.response.data.mensagens;
                        }
                        else {
                            this.mensagem = "Servi�o indispon�vel. Tente novamente mais tarde.";
                        }

                    });
            }


            function formatarStatus(agendamento){
                if(agendamento.enviado){
                    agendamento.status = "Enviado";
                }
                else{
                    agendamento.status = "N�o Enviado";
                }
            }
        </script>
</body>
</html>