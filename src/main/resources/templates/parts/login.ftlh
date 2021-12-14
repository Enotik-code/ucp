<#macro login path isRegisterForm>
    <div class="container">
        <h1 class="display-4 mb-5">Войти</h1>

        <form action="${path}" method="post"  class="inline mt-5">
            <div class="form-group row h-35">
                <label class="col-sm-2  col-form-label ml-2"><h3>Имя: </h3></label>
                <div class="col-sm-8">
                    <input type="text" name="username" class="form-control form-control-lg  w-100 h-100 leed" placeholder="имя пользователя" />
                </div>
            </div>
            <div class="form-group row h-35">
                <label class="col-sm-2 col-form-label ml-2"><h3>Пароль: </h3></label>
                <div class="col-sm-8">
                    <input type="password" name="password" class="form-control w-100 h-100 form-control-lg leed" placeholder="пароль" />
                </div>
            </div>
            <#if isRegisterForm>
                <div class="form-group row h-35">
                    <label class="col-sm-2 col-form-label ml-2"><h3>Выберите роль: </h3></label>
                    <div class="col-sm-8">
                        <select class="custom-select form-control-lg form-control w-100 h-100" name="select" required id="roleSelect">
                            <option selected>Choose...</option>
                            <option value="Client" name="Client">Client</option>
                            <option value="Carrier" name="Carrier">Carrier</option>
                        </select>
                    </div>
                </div>
            </#if>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group row">

                <div class="p-3">
                    <button class="btn btn-secondary" type="submit"><#if isRegisterForm><h4>Создать</h4><#else> <h4>Войти</h4></#if></button>
                </div>

                <div class="p-3 align-middle">
                    <div class="mt-2">
                        <#if !isRegisterForm> <a href="/registration" class="text-secondary"> <h4>Зарегистрироваться</h4></a></#if>
                    </div>
                </div>
            </div>
        </form>
    </div>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button class="btn btn-secondary btn-lg" type="submit">Выйти</button>
    </form>
</#macro>