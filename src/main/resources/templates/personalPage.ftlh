<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="container">
        <h1 class="font-weight-light mb-5"> Личный кабинет </h1>
        <form action="/personalPage" method="post" enctype="multipart/form-data">

            <#if user.filename??>
                <div class="mt-5">
                    <div class="figure">
                        <img src="/static/${user.filename}" class="img-thumbnail rounded" alt="картинка не загрузилась">
                        <figcaption class="text-center"><p>Аватарка</p></figcaption>
                    </div>
                </div>
            </#if>

            <div class="form-row ">
                <h3 class="font-weight-light mb-5"> Выберите файл для новой аватарки: </h3>
                <input class="ml-4" type="file" name="file" id="customFile">
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="username"><h3 class="font-weight-light ">Логин</h3></label>
                    <input type="text" class="form-control"  name="username" value="${user.username}" >
                </div>
                <div class="form-group col-md-6">
                    <label for="password"><h3 class="font-weight-light ">Пароль</h3></label>
                    <input type="password" class="form-control" name="password" value="${user.password}" >
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="initials"><h3 class="font-weight-light">Инициалы</h3></label>
                    <input type="text" class="form-control"  name="initials" value="${user.initials!"инициалы отсутствует"}" >
                </div>
                <div class="form-group col-md-6">
                    <label for="mail"><h3 class="font-weight-light">Элпочта</h3></label>
                    <input type="mail" class="form-control" name="mail"  value="${user.mail!"почта отсутствует"}">
                </div>
            </div>
            <div class="form-row">

                <div class="form-group col-md-4">
                    <label for="age"><h3 class="font-weight-light">Возраст</h3></label>
                    <input type="text" class="form-control"  name="age" value="${user.age!"возраст не указан"}" >
                </div>
                <#list roles as role>
                    <div class="form-check mt-5 ml-3">
                        <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")} disabled>${role}</label>
                    </div>
                </#list>
            </div>
            <input type="hidden" value="${user.id}" name="id">
            <input type="hidden" value="${_csrf.token}" name="_csrf">
            <button type="submit" class="btn btn-secondary btn-lg">Отредактировать</button>
        </form>
    </div>

</@c.page>