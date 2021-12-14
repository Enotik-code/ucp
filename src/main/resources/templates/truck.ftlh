<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="container">

        <a class="btn btn-secondary btn-lg mb-1" id="input1" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
            Добавить транспорт
        </a>

        <div class="collapse" id="collapseExample">
            <div class="form-group mt-1">
                <form method="post" enctype="multipart/form-data" action="/truck">

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Марка:</h3></label>
                            <input type="text" class="form-control" name="band" placeholder=" ...">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="type"><h3 class="font-weight-light ">Модель:</h3></label>
                            <input type="text" class="form-control" name="truckModel" placeholder=" ...">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Номер:</h3></label>
                            <input type="text" class="form-control" name="plateNumber" placeholder=" ...">
                        </div>
                        <div class="form-group col-md-6">
                            <label for="type"><h3 class="font-weight-light ">Грузоподъемность:</h3></label>
                            <input type="text" class="form-control" name="liftingCapacity" placeholder=" ...">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="name"><h3 class="font-weight-light ">Тип:</h3></label>
                            <input type="text" class="form-control" name="type" placeholder=" ...">
                        </div>
                    </div>

                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <div class="form-group">
                        <button type="submit" class="btn btn-secondary btn-lg mt-3">Добавить</button>
                    </div>
                </form>
            </div>
        </div>

        <#if trucks??>
            <div class="container mt-3 mb-2">
                <#if trucks??>
                <table class="table table-hover table-sm">
                    <thead>
                    <tr>
                        <th class="h4 font-weight-normal" scope="col">#</th>
                        <th class="h4 font-weight-normal" scope="col">Марка</th>
                        <th class="h4 font-weight-normal" scope="col">Модель</th>
                        <th class="h4 font-weight-normal" scope="col">Номера</th>
                        <th class="h4 font-weight-normal" scope="col">Грузоподъемность</th>
                        <th class="h4 font-weight-normal" scope="col">Тип</th>
                        <th class="h4 font-weight-normal" scope="col">Занят</th>
                        <th class="h4 font-weight-normal" scope="col"></th>
                        <th class="h4 font-weight-normal" scope="col"></th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <#list trucks as truck>
                        <tr>
                            <td class="h4 font-weight-normal"> ${truck? counter} </td>
                            <td class="h4 font-weight-normal">${truck.band}</td>
                            <td class="h4 font-weight-normal">${truck.truckModel}</td>
                            <td class="h4 font-weight-normal">${truck.plateNumber}</td>
                            <td class="h4 font-weight-normal">${truck.liftingCapacity}</td>
                            <td class="h4 font-weight-normal">${truck.type}</td>
                            <#if truck.isBusy()>
                                <td class="h4 font-weight-normal">Оформлен</td>
                            <#else> <td class="h4 font-weight-normal">Не оформлен</td>
                            </#if>
                            <#if !truck.isBusy()><td class="h4 font-weight-normal"><a href="/truckDownload/${truck.id}">загрузить</a></td> </#if>
                            <td class="h4 font-weight-normal"><a href="/truck/${truck.id}">удалить</a></td>
                        </tr>
                    <#else>
                        <h3>Транспорта не найдено</h3>
                    </#list>
                    </tbody>
                </table>
                </#if>
            </div>
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