<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="container">

        <a class="btn btn-secondary btn-lg mb-1" id="input1" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Добавить груз
        </a>

        <div class="collapse" id="collapseExample">
            <div class="form-group mt-1">
                <form method="post" enctype="multipart/form-data" action="/cargo">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Название:</h3></label>
                            <input type="text" class="form-control" name="name" placeholder=" ...">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="type"><h3 class="font-weight-light ">Стоимость:</h3></label>
                            <input type="text" class="form-control" name="cost" placeholder=" ...">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Объем:</h3></label>
                            <input type="text" class="form-control" name="capacity" placeholder=" ...">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Вес:</h3></label>
                            <input type="text" class="form-control" name="weight" placeholder=" ...">
                        </div>
                    </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-secondary btn-lg mt-3">Добавить</button>
                    </div>
                </form>
            </div>
        </div>



        <#if cargos??>
            <#assign count = 0>
            <div class="container mt-3 mb-2">
                    <table class="table table-hover table-sm">
                        <thead>
                        <tr>
                            <th class="h4 font-weight-normal" scope="col">#</th>
                            <th class="h4 font-weight-normal" scope="col">Название</th>
                            <th class="h4 font-weight-normal" scope="col">Стоимость</th>
                            <th class="h4 font-weight-normal" scope="col">Объем</th>
                            <th class="h4 font-weight-normal" scope="col">Вес</th>
                            <th class="h4 font-weight-normal" scope="col">Статус</th>
                            <th class="h4 font-weight-normal" scope="col"></th>
                            <th class="h4 font-weight-normal" scope="col"></th>
                        </tr>
                        </thead>
                        <tbody id="myTable">
                        <#list cargos as cargo>
                            <tr>
                                <td class="h4 font-weight-normal"> ${cargo? counter} </td>
                                <td class="h4 font-weight-normal">${cargo.name}</td>
                                <td class="h4 font-weight-normal">${cargo.cost}</td>
                                <td class="h4 font-weight-normal">${cargo.capacity}</td>
                                <td class="h4 font-weight-normal">${cargo.weight}</td>
                                <#if cargo.isClose()>
                                    <td class="h4 font-weight-normal">Оформлен</td>
                                <#else> <td class="h4 font-weight-normal">Не оформлен</td>
                                </#if>
                                <td class="h4 font-weight-normal"><a href="/cargo/${cargo.id}">удалить</a></td>
                                <#if !cargo.isClose()><td class="h4 font-weight-normal"><a href="/cargoDelivery/${cargo.id}">доставка</a></td> </#if>
                            </tr>
                            <#assign count = count + 1>
                        </#list>
                        </tbody>
                    </table>
            </div>
        <#else> <h3> Вы еще не добавили груз </h3>
        </#if>

        <script>
            $(document).ready(function(){
                $("#myInput").on("keyup", function() {
                    var value = $(this).val().toLowerCase();
                    $("#myTable tr").filter(function() {
                        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                    });
                });
            });
        </script>

        <script defer>

            function twoFunc () {
                document.getElementById('input1').style.display="none";
            }
            document.getElementById('input1').addEventListener('click', twoFunc, false);

        </script>
    </div>
</@c.page>