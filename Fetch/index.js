let result = '';
var space = ' ';
const values = document.getElementById("values").textContent.split("\n ");
const URLs = document.getElementById("urls").textContent.split("\n ");
values.splice(0, 1);
URLs.splice(0, 1);

document
  .querySelector('button')
  .addEventListener('click',
  async ({ target: t }) => { 
    t.textContent = 'start';
    for(var i in URLs) {
      let opt = { 
        headers: new Headers({
          'Content-Type': 'application/json'
        })}; 
      let response = await fetch(URLs[i].trim()+ values[i].trim() + '/' + result, opt).then(x => x.json());
      result = response.result;
    }
      t.textContent = `Результат: ${result}`;
    }
); 