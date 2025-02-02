const htmlToImage = require("html-to-image");

const node = document.getElementById("conteudoValidacao");

//console.log(node);

htmlToImage
  .toPng(node)
  .then((dataUrl) => {
    let img = new Image();
    img.src = dataUrl;
    document.getElementById("conteudo").appendChild(img);
  })
  .catch((error) => {
    console.error("ops... derrota!!!!", error);
  });
