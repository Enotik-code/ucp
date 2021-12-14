<#import "parts/common.ftlh" as c>

<@c.page>


    <#if !company??>
        <div class="container">

            <h3> У вас не добавлена компания</h3>
            <div class="pb-3"> </div>

            <a class="btn btn-secondary btn-lg" id="input1" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
                Добавить компанию
            </a>

            <div class="collapse" id="collapseExample">
                <div class="form-group mt-3">
                    <form method="post" enctype="multipart/form-data">

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="name" ><h3 class="font-weight-light ">Название компании:</h3></label>
                                <input type="text" class="form-control" name="name" placeholder=" ...">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="address"><h3 class="font-weight-light ">Адрес:</h3></label>
                                <input type="text" class="form-control" name="address" placeholder=" ...">
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="type" ><h3 class="font-weight-light ">Временной коэффициент:</h3></label>
                                <input type="text" class="form-control" name="deliveryTimeCoefficient" placeholder=" ">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="director"><h3 class="font-weight-light ">Коэффициент стоимости:</h3></label>
                                <input type="text" class="form-control" name="deliveryCostCoefficient" placeholder=" ">
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="mail" ><h3 class="font-weight-light ">Мэил:</h3></label>
                                <input type="text" class="form-control" name="mail" placeholder=" qwerty@gmail.com">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="telephone"><h3 class="font-weight-light ">Телефон:</h3></label>
                                <input type="text" class="form-control" name="telephone" placeholder=" +375-29(33)-###-##-##">
                            </div>
                        </div>
                        <input class="ml-4" type="file" hidden name="file" id="customFile">
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <div class="form-group">
                            <button type="submit" class="btn btn-secondary btn-lg mt-3">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </#if>

    <#if company??>

            <div class="row row justify-content-md-center">
                <div class="jumbotron jumbotron-fluid col-sm-6">
                    <div class="container">
                        <div class="d-flex w-100 justify-content-between">
                            <h1 class="display-4">Компания:  ${company.name} </h1>
                        </div>
                        <div class="list-group mt-3">
                            <h3 class="font-weight-normal">Электронная почта: ${company.mail}</h3>
                            <h3 class="font-weight-normal">Контактный телефон: ${company.telephone}</h3>
                        </div>
                    </div>
                </div>
                <div class="jumbotron jumbotron-fluid col-sm-2">
                    <div class="btn-group-vertical h-100 w-95 mr-1">
                        <a href="/rendCompany" class="btn btn-secondary btn-lg" role="button">Изменить компанию</a>
                        <a href="/delCompany" class="btn btn-secondary btn-lg" role="button">Удалить компанию</a>
                        <a href="/truck" class="btn btn-secondary btn-lg" role="button">Автопарк</a>
                    </div>
                </div>

            </div>








    </#if>




    <script defer>

        function twoFunc () {
            document.getElementById('input1').style.display="none";
        }
        document.getElementById('input1').addEventListener('click', twoFunc, false);

    </script>

</@c.page>