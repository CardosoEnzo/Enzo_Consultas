const btnListar = document.getElementById('btnListar');
const content = document.getElementById('content');

const fetchApi = () => {
    const resultado = fetch('http://localhost:8080/listar').then((res) => res.json())
        .then((data) => {
            console.log(data);
            return data;
        });

    return resultado;
}

btnListar.addEventListener('click', async(event) => {
    event.preventDefault();
    const result = await fetchApi();
    content.textContent = `${JSON.stringify(result, undefined, 2)}`;
});