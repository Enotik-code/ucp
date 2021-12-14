<#import "parts/common.ftlh" as c>

<@c.page>

    <div class="container">

        <#if bestset??>
            <div class="container mt-3 mb-2">
                <h3> Результат загрузки машины</h3>
                <h3> Объем машины:  ${capacity}</h3>
                <h3> Общая стоимость:  ${cost}</h3>
                <table class="table table-hover table-sm">
                    <thead>
                    <tr>
                        <th class="h4 font-weight-normal" scope="col">#</th>
                        <th class="h4 font-weight-normal" scope="col">Название груза</th>
                        <th class="h4 font-weight-normal" scope="col">Стоимость</th>
                        <th class="h4 font-weight-normal" scope="col">Объем</th>
                    </tr>
                    </thead>
                    <tbody id="myTable">
                    <#list bestset as delivery>
                        <tr>
                            <td class="h4 font-weight-normal"> ${delivery? counter} </td>
                            <td class="h4 font-weight-normal">${delivery.getCargoName()}</td>
                            <td class="h4 font-weight-normal">${delivery.getDeliveryCost()}</td>
                            <td class="h4 font-weight-normal">${delivery.getVolume()}</td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        <#else> <h4> Ошибка: заказов нет </h4>
        </#if>


    </div>


</@c.page>