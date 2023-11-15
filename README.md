# crud-spring-api
API com um CRUD feito em spring.

# métodos
> #### (GET)    /users
>
> - Recebe todos os usuários cadastrados.

> #### (POST)    /users
>
> - Cadastra um novo usuário.
>
>  *nome* opcional.
>  *email* opcional.
>  *telefone* opcional.
>  *password* opcional.

> #### (GET)    /users/{id}
>
> - Recebe um usuário com o id especificado ou retorna erro caso ele não exista.

> #### (PUT)    /users/{id}
>
> - Atualiza um usuário com o id especificado.
>
>  *nome* opcional.
>  *email* opcional.
>  *telefone* opcional.
>  *password* opcional.

> #### (DELETE)    /users/{id}
>
> - Remove um usuário com o id especificado ou retorna erro caso ele não exista.
