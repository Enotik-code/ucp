<#import "parts/common.ftlh" as c>

<@c.page>

            <form method="post" enctype="multipart/form-data">
                <h1 class="display-4 mb-5">Панель редактирования</h1>
                <div class="form-group row mb-2">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Название компании :</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="name" value="${company.name}" placeholder=" ..." />
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Адрес:</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="address" value="${company.address}" placeholder=" ..."> </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Среднее время доставки:</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="deliveryTime" value="${company.deliveryTime}" placeholder=" ..."> </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Стоимость доставки:</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="deliveryCost" value="${company.deliveryCost}" placeholder=" ..."> </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Мэил:</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="mail" value="${company.mail}" placeholder=" ..."> </div>
                </div>

                <div class="form-group row">
                    <label class="col-sm-2 col-form-label ml-2"><h4>Телефон:</h4></label>
                    <div class="col-sm-6 mt-2">
                        <input type="text" class="form-control" name="telephone" value="${company.telephone}" placeholder=" +375-29(33)-###-##-##"> </div>
                </div>
                <input type="hidden" name="_csrf" value="${_csrf.token}" />
                <div class="form-group mb-2">
                    <button type="submit" class="btn btn-secondary"><h4>Отредактировать</h4></button>
                </div>
            </form>
</@c.page>