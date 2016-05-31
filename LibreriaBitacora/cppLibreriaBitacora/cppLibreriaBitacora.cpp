

#include "stdafx.h"
#include <iostream>
#include "Controlador_AbstractControlador.h"
#include "cppLibreriaBitacora.h"
#include <string>

using System::Text::Encoding;
String^ convertir(const char *caracteres) {
	int largo = (int)strlen(caracteres);
	array<unsigned char>^ texto = gcnew array<unsigned char>(largo);
	for (int contador = 0; contador < largo; contador++) {
		if (caracteres[contador] == '.') {
			texto[contador] = ',';
		}
		else {
			texto[contador] = caracteres[contador];
		}
	}
	return Encoding::UTF8->GetString(texto);
}
void escribir(const char *monto, const char *nombre, const char *periodo, const char *tipoMoneda, const char *sistema, const char *interes) {
	LibreriaBitacora::Bitacora bita;
	bita.escribir(convertir(monto), convertir(interes), convertir(periodo), convertir(tipoMoneda), convertir(sistema), convertir(nombre));
}

JNIEXPORT void JNICALL Java_Controlador_AbstractControlador_escribir(JNIEnv *env, jobject info, jstring monto, jstring interes, jstring periodo, jstring moneda, jstring sistema, jstring nombre) {
	jboolean isMonto;
	const char* convertido_monto = env->GetStringUTFChars(monto, &isMonto);
	jboolean isinteres;
	const char* convertido_interes = env->GetStringUTFChars(interes, &isinteres);
	jboolean isperiodo;
	const char* convertido_periodo = env->GetStringUTFChars(periodo, &isperiodo);
	jboolean ismoneda;
	const char* convertido_moneda = env->GetStringUTFChars(moneda, &ismoneda);
	jboolean issistema;
	const char* convertido_sistema = env->GetStringUTFChars(sistema, &issistema);
	jboolean isnombre;
	const char* convertido_nombre = env->GetStringUTFChars(nombre, &isnombre);
	escribir(convertido_monto, convertido_nombre, convertido_periodo, convertido_moneda, convertido_sistema, convertido_interes);
	env->ReleaseStringUTFChars(monto, convertido_monto);
	env->ReleaseStringUTFChars(interes, convertido_interes);
	env->ReleaseStringUTFChars(periodo, convertido_periodo);
	env->ReleaseStringUTFChars(moneda, convertido_moneda);
	env->ReleaseStringUTFChars(sistema, convertido_sistema);
	env->ReleaseStringUTFChars(nombre, convertido_nombre);
}