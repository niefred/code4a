var dir = 'c:\lun\test'
var fs = require('fs')
fs.readdir(dir, function(err,fileNames) {
  if(err) {
    console.error('Could not read '+dir+': '+err)
    return
  }
  fileNames.forEach(function(fileName) {
    var oldPath = dir + '/' + fileName
    var newPath = dir + '/' + convert(fileName)
    //console.log('Renaming: '+oldPath+' to '+newPath)
    fs.rename(oldPath, newPath, function(err) {
      if(err) {
        console.log('Could not rename '+oldPath+' to '+newPath)
      } else {
        console.log('Renamed '+oldPath+' to '+newPath)
      }
    })
  })
})

function convert(fileName) {
  if(fileName.charAt(0)==fileName.charAt(0).toUpperCase()) {
    return fileName.toLowerCase()
  } else {
    return fileName.toUpperCase()
  }
}
